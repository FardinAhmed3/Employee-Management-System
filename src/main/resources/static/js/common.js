document.addEventListener('DOMContentLoaded', (event) => {
    // Basic Form Validation Example
    const addEditForm = document.querySelector('form');
    if (addEditForm) {
        addEditForm.addEventListener('submit', (e) => {
            let formValid = true;

            // Validate that email is not empty
            const emailInput = document.querySelector('input[type="email"]');
            if (emailInput && emailInput.value.trim() === '') {
                alert('Email cannot be empty.');
                formValid = false;
                e.preventDefault();  // Correctly using preventDefault as a function call
            }

            // Validate that first name is not empty
            const firstNameInput = document.querySelector('input[name="firstName"]'); // Corrected the selector
            if (firstNameInput && firstNameInput.value.trim() === '') {
                alert('First Name cannot be left empty');
                formValid = false;
                e.preventDefault();  // Correctly using preventDefault as a function call
            }
        });
    }
});
