// common.js

document.addEventListener('DOMContentLoaded', (event) => {
    // Basic Form Validation Example
    const addEditForm = document.querySelector('form');
    if (addEditForm) {
        addEditForm.addEventListener('submit', (e) => {
            // Example: Validate that email is not empty
            const emailInput = document.querySelector('input[type="email"]');
            if (emailInput && emailInput.value === '') {
                alert('Email is required.');
                e.preventDefault(); // Prevent form submission
            }
            // Add other validation checks as needed
        });
    }
});
