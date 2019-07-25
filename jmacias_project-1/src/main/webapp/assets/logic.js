const modalHTM = document.querySelector("#modal");
const modalTitleHTM = document.querySelector("#modal-title");
const nameInput = document.querySelector("#name-input");
const pwInput = document.querySelector("#pw-input");
const closerHTM = document.querySelector(".closer");

const loginButtonHTM = document.querySelector("#login-button");
const signupButtonHTM = document.querySelector("#signup-button");
const formSubmit = document.querySelector("#form-submit");

const xhr = new XMLHttpRequest();
const xhr2 = new XMLHttpRequest();

function toggleModal() {
  if (toggleBoolean) {
    modalHTM.className = "modal is-active";
  }
  else {
    modalHTM.className = "modal";
  }
  toggleBoolean = !toggleBoolean;
}
let option;
function loginModal() {
  modalTitleHTM.textContent = "Please Log In";
  // nameInput.setAttribute("name", "user-name");
  option = "login";
  // nInputHTM.setAttribute("name", "user-name");

  toggleModal();
}
function signUp() {
  option = "signup";
  console.log("signup clicked");

  // xhr2.onreadystatechange = function () {
  //   if (this.readyState == 4 && this.status == 200) {
  //     console.log("ran");
  //   }
  // }
  // xhr2.open("GET", "http://localhost:8080/jmacias_project-1/api/Project1Servlet?option=signup");
  // console.log(`option=${option}`);
  // xhr2.responseType = "document";
  // xhr2.send();
  window.location.href = "http://localhost:8080/jmacias_project-1/api/Project1Servlet?option=signup";
}
formSubmit.addEventListener("click", function (e) {
  e.preventDefault();
  console.log("clicked");
  xhr.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      if (xhr.responseText === "failed") {
        alert("sorry, your login was unsuccessful");
        window.location.href = "http://localhost:8080/jmacias_project-1/";
      }
      else if (xhr.responseText) {
        console.log("======= xhr text: " + xhr.responseText);
       window.location.href = "http://localhost:8080/jmacias_project-1/api/Project1Servlet?option=" + xhr.responseText;
      }
      else {
        console.log("hmmm . . .");
      }
    }
  }
  xhr.open("POST", "http://localhost:8080/jmacias_project-1/api/Project1Servlet");
  let uName = document.querySelector("#name-input").value;
  let pWord = document.querySelector("#pw-input").value;
  console.log(`name=${uName}&password=${pWord}&option=${option}`);
  xhr.send("name=" + uName + "&password=" + pWord + "&option=" + option);
});

let toggleBoolean = false;
loginButtonHTM.addEventListener("click", loginModal);
signupButtonHTM.addEventListener("click", signUp);
closerHTM.addEventListener("click", toggleModal);