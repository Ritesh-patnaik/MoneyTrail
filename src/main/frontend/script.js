// Add interactivity to the website

document.addEventListener("DOMContentLoaded", () => {
    // Smooth scroll for navigation links
    const navLinks = document.querySelectorAll(".nav-links a");

    navLinks.forEach(link => {
        link.addEventListener("click", event => {
            event.preventDefault();
            const targetId = link.getAttribute("href").substring(1);
            const targetSection = document.getElementById(targetId);

            if (targetSection) {
                window.scrollTo({
                    top: targetSection.offsetTop - 50,
                    behavior: "smooth"
                });
            }
        });
    });

    // Add button click alert in Hero Section
    const heroButton = document.querySelector(".hero .btn");

    heroButton.addEventListener("click", () => {
        alert("Welcome to MoneyTrail! Let's get started.");
    });

    // Basic form validation for Contact Us
    const contactForm = document.querySelector("form");

    contactForm.addEventListener("submit", event => {
        const name = document.getElementById("name").value.trim();
        const email = document.getElementById("email").value.trim();
        const message = document.getElementById("message").value.trim();

        if (!name || !email || !message) {
            event.preventDefault();
            alert("All fields are required. Please fill out the form completely.");
        } else if (!validateEmail(email)) {
            event.preventDefault();
            alert("Please enter a valid email address.");
        }
    });

    // Select the button using its ID
const cashierButton = document.getElementById('cashierButton');

// Add a click event listener to the button
cashierButton.addEventListener('click', function () {
    // Redirect to the cashier.html page
    window.location.href = 'cashier.html';
});


    // Utility function to validate email
    function validateEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});

