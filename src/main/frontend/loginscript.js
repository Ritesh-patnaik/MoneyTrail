// Theme toggle functionality
const themeToggleButton = document.getElementById('themeToggle');
const body = document.body;

themeToggleButton.addEventListener('click', () => {
    body.classList.toggle('dark-mode');
    themeToggleButton.textContent = body.classList.contains('dark-mode') ? 'Switch to Light Mode' : 'Switch to Dark Mode';
});

// Form submission logic with validation
const loginForm = document.getElementById('loginForm');
const emailInput = document.getElementById('email');
const passwordInput = document.getElementById('password');
const errorDiv = document.getElementById('error');

loginForm.addEventListener('submit', function (e) {
    e.preventDefault();  // Prevent form from submitting normally

    // Clear any previous errors
    errorDiv.textContent = '';

    // Basic validation
    if (!emailInput.value || !passwordInput.value) {
        errorDiv.textContent = 'Please fill in both email and password fields.';
        return;
    }

    // Simulate successful login (here you can add actual authentication logic)
    alert('Login successful!');

    // Redirect to another page (e.g., dashboard or home page)
    window.location.href = 'index.html';  // Change 'dashboard.html' to your desired page
});
