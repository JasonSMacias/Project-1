const modalHTM = document.querySelector("#modal");
const modalTitleHTM = document.querySelector("modal-title");
const modalContentHTM = document.querySelector("modal-content");
const closerHTM = document.querySelector(".closer");

const loginButtonHTM = document.querySelector("#login-button");
const signupButtonHTM = document.querySelector("#signup-button");

function toggleModal() {
  if (toggleBoolean) {
    modalHTM.className = "modal is-active";
  }
  else {
    modalHTM.className = "modal";
  }
  toggleBoolean = !toggleBoolean;
}
let toggleBoolean = false;
loginButtonHTM.addEventListener("click", toggleModal);
signupButtonHTM.addEventListener("click", toggleModal);
closerHTM.addEventListener("click", toggleModal);