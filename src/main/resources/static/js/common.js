document.addEventListener('DOMContentLoaded', (event) => {
    // Basic Form Validation Example
    const addEditForm = document.querySelector('form');
    if (addEditForm) {
        addEditForm.addEventListener('submit', (e) => {
            let formValid = true;
            
            // Validate first name, last name, and middle name for non-alphabetic characters
            ['firstName', 'lastName', 'middleName'].forEach(function(fieldId) {
            const inputField = document.getElementById(fieldId);
                if (inputField && containsNonAlphabetic(inputField.value)) {
                    alert('Name fields should only contain alphabetic characters.');
                    formValid = false;
                    e.preventDefault();
                }
            });

            // Validate that email is not empty
            const emailInput = document.querySelector('input[type="email"]');
            if (emailInput && emailInput.value.trim() === '') {
                alert('Email cannot be empty.');
                formValid = false;
                e.preventDefault(); 
            }

            // Validate that first name is not empty
            const firstNameInput = document.querySelector('input[name="firstName"]');
            if (firstNameInput && firstNameInput.value.trim() === '') {
                alert('First Name cannot be left empty.');
                formValid = false;
                e.preventDefault(); 
            }
            
            //Validating DOB & if Age <18
            const dobInput=document.querySelector('input[name="dateOfBirth"]');
            if (dobInput && dobInput.value.trim()===''){
				alert('Date of birth cannot be left empty.');
				formValid= false;
				e.preventDefault();
			}
            if (dobInput && !isValidAge(dobInput.value)) {
                alert('Employee must be at least 18 years old.');
                formValid = false;
                e.preventDefault();  
            }
            // other validation checks 
        });
    }
});

function isValidAge(dob) {
    const currentDate = new Date();
    const enteredDate = new Date(dob);
    const age = currentDate.getFullYear() - enteredDate.getFullYear();
    const monthDifference = currentDate.getMonth() - enteredDate.getMonth();
    if (monthDifference < 0 || (monthDifference === 0 && currentDate.getDate() < enteredDate.getDate())) {
        age--;
    }
    return age >= 18;
}		

// Function to check for non-alphabetic characters
function containsNonAlphabetic(value) {
// Matches any character that is not a letter
return /[^A-Za-z0-9]/.test(value);
}