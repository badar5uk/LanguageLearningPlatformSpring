const form = document.querySelector("form"),
  emailField = form.querySelector(".email-field"),
  emailInput = emailField.querySelector(".email"),
  passField = form.querySelector(".create-password"),
  passInput = passField.querySelector(".password"),
  cPassField = form.querySelector(".confirm-password"),
  cPassInput = cPassField.querySelector(".cPassword");

// Email Validation
function checkEmail() {
  const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  if (!emailInput.value.match(emailPattern)) {
    return emailField.classList.add("invalid"); // Adding invalid class if email value doesn't match the email pattern
  }
  emailField.classList.remove("invalid"); // Removing invalid class if email value matches the email pattern
}

// Hide and show password
const eyeIcons = document.querySelectorAll(".show-hide");
eyeIcons.forEach((eyeIcon) => {
  eyeIcon.addEventListener("click", () => {
    const pInput = eyeIcon.parentElement.querySelector("input"); // Getting parent element of eye icon and selecting the password input
    if (pInput.type === "password") {
      eyeIcon.classList.replace("bx-hide", "bx-show");
      return (pInput.type = "text");
    }
    eyeIcon.classList.replace("bx-show", "bx-hide");
    pInput.type = "password";
  });
});

// Password Validation
function createPass() {
  const passPattern =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  if (!passInput.value.match(passPattern)) {
    return passField.classList.add("invalid"); // Adding invalid class if password input value doesn't match the passPattern
  }
  passField.classList.remove("invalid"); // Removing invalid class if password input value matches the passPattern
}

// Confirm Password Validation
function confirmPass() {
  if (passInput.value !== cPassInput.value || cPassInput.value === "") {
    return cPassField.classList.add("invalid");
  }
  cPassField.classList.remove("invalid");
}

// Fetch function to handle login or registration
function submitFormData(url, data) {
  fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data), // Send form data as JSON
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.success) {
        // Redirect on success
        location.href = data.redirectUrl || "/dashboard"; // You can change the redirect URL
      } else {
        // Show error message if the response indicates failure
        alert(data.message || "Something went wrong.");
      }
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("There was an error processing your request.");
    });
}

// Calling function on form submit
form.addEventListener("submit", (e) => {
  e.preventDefault(); // Preventing form from submitting

  checkEmail();
  createPass();
  confirmPass();

  // Calling function on key up
  emailInput.addEventListener("keyup", checkEmail);
  passInput.addEventListener("keyup", createPass);
  cPassInput.addEventListener("keyup", confirmPass);

  if (
    !emailField.classList.contains("invalid") &&
    !passField.classList.contains("invalid") &&
    !cPassField.classList.contains("invalid")
  ) {
    // Collect form data
    const formData = new FormData(form);
    const data = Object.fromEntries(formData); // Convert FormData to a plain object

    const isLoginForm = form.querySelector(".login"); // Check if it's a login form (you can also check form action here)
    const actionURL = form.getAttribute("action"); // This is where the form sends data (login or register endpoint)
    
    // Send appropriate fetch request based on form type
    if (isLoginForm) {
      // Login form
      submitFormData("/login", data); // Replace "/login" with the correct login endpoint
    } else {
      // Register form
      submitFormData("/register", data); // Replace "/register" with the correct register endpoint
    }
  }
});
