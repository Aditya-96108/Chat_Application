// Include SockJS and Stomp.js libraries

let stompClient;
let senderName = prompt("Enter your name:");

// Function to connect to the WebSocket server
function connect() {
    const socket = new SockJS('http://localhost:8080/chat'); // WebSocket URL
    stompClient = Stomp.over(socket);

    // Disable debug messages
    stompClient.debug = null;

    // Connect to the server
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);

        // Subscribe to the topic
        stompClient.subscribe('/topic/public', function(messageOutput) {
            const message = JSON.parse(messageOutput.body);
            displayMessage(message.sender, message.content, message.type);
        });

        // Request previous messages when the user joins
        fetchPreviousMessages();
    }, function(error) {
        console.error('Error connecting to WebSocket:', error);
    });
}

// Function to fetch previous chat messages from the backend
function fetchPreviousMessages() {
    fetch('http://localhost:8080/chat/all')
        .then(response => response.json())
        .then(messages => {
            messages.forEach(message => {
                displayMessage(message.sender, message.content, message.type);
            });
        })
        .catch(error => console.error('Error fetching previous messages:', error));
}

// Function to send a message
function sendMessage() {
    const messageInput = document.getElementById('messageInput');
    const content = messageInput.value;

    if (content && stompClient) {
        const message = {
            sender: senderName,
            content: content,
            type: 'CHAT' // You can modify this based on user input (JOIN, LEAVE, or CHAT)
        };
        stompClient.send('/app/sendMessage', {}, JSON.stringify(message));
        messageInput.value = ''; // Clear input field
    } else {
        alert('Please enter a message or check the WebSocket connection.');
    }
}

// Function to send leave message
function leaveChat() {
    if (stompClient) {
        const message = {
            sender: senderName,
            content: 'Left the chat.',
            type: 'LEAVE'
        };
        stompClient.send('/app/sendMessage', {}, JSON.stringify(message));
        alert('You have left the chat.');
        window.location.reload(); // Reload the page after leaving
    }
}

// Function to display a message in the UI
function displayMessage(sender, content, type) {
    const messageBox = document.getElementById('messageBox');
    const messageElement = document.createElement('p');
    messageElement.textContent = `[${type}] ${sender}: ${content}`;
    messageBox.appendChild(messageElement);
    messageBox.scrollTop = messageBox.scrollHeight; // Auto-scroll to the bottom
}

// Attach event listeners
document.getElementById('sendButton').addEventListener('click', sendMessage);
document.getElementById('messageInput').addEventListener('keypress', function(event) {
    if (event.key === 'Enter') {
        sendMessage();
    }
});
document.getElementById('leaveButton').addEventListener('click', leaveChat);

// Connect to WebSocket on page load
window.onload = connect;
