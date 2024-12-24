// Update Transaction Form
const updateTransactionForm = document.getElementById('updateTransactionForm');
updateTransactionForm.addEventListener('submit', function (e) {
    e.preventDefault();
    const transactionType = document.getElementById('transactionType').value;
    const amount = document.getElementById('amount').value;
    const password = document.getElementById('password').value;

    // Example password validation (replace with your actual logic)
 const correctPassword = 'admin123'; // Replace this with secure backend validation

 if (password !== correctPassword) {
     alert('Incorrect password! Transaction denied.');
     return;
 }

   
 //const data = await response.json();
    if (transactionType && amount) {
        alert(`${transactionType === 'credit' ? 'Credited' : 'Debited'} ₹${amount} successfully! & Remaining Balance: ₹ `);
        //alert(`${data.message}\nRemaining Balance: ₹${data.remainingBalance}`);
        updateTransactionForm.reset(); // Clear form fields
    } else {
        alert('Please fill in all fields!');
    }
});


 