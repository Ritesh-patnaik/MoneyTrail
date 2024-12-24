// Add New User Form
const addUserForm = document.getElementById('addUserForm');
addUserForm.addEventListener('submit', function (e) {
    e.preventDefault();
    const userName = document.getElementById('userName').value;
    const userEmail = document.getElementById('userEmail').value;
     // Example password validation (replace with your actual logic)
     const correctPassword = 'admin123'; // Replace this with secure backend validation

     if (password !== correctPassword) {
         alert('Incorrect password! Transaction denied.');
         return;
     }

    if (userName && userEmail) {
        alert(`User ${userName} added successfully!`);
        addUserForm.reset(); // Clear form fields
    } else {
        alert('Please fill in all fields!');
    }
});
   // Select the button using its ID
   const Submitbutton = document.getElementById('submit');

   // Add a click event listener to the button
   Submitbutton.addEventListener('click', function () {
       // Redirect to the cashier.html page
       window.location.href = 'user.html';
   });
   

   
