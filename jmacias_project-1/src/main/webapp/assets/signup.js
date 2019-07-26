const nameInputHTM = document.querySelector("#name-input");
const pwInputHTM = document.querySelector("#pw-input");
const pw2InputHTM = document.querySelector("#pw2-input");
const securityQInputHTM = document.querySelector("#securityq-input");
const securityAInputHTM = document.querySelector("#securitya-input");
let tempRadios = document.getElementsByName("role");
const logoutButtonHTM = document.querySelector("#logout-button");
const submitButtonHTM = document.querySelector("#submit-button");
const signInForm = document.querySelector("#sign-in-form");
const dropSubmit = document.querySelector("#drop-submit");

const nameTargetHTM = document.querySelector("#name-target");
const roleTargetHTM = document.querySelector("#role-target");
const securityQTargetHTM = document.querySelector("#securityq-target");
const securityATargetHTM = document.querySelector("#securitya-target");

function getRadioVal() {
  const roleInputsHTM = document.getElementsByName("role");
  console.log(roleInputsHTM);
  let role;
  console.log("radioval");
  for (let x of roleInputsHTM) {
    if (x.checked) {
      console.log(x.value);
      role = x.value;
      break;
    }
  }
  roleTargetHTM.textContent = role;
};
function updateName(e) {
  console.log("keyup");
  nameTargetHTM.textContent = nameInputHTM.value;
  securityQTargetHTM.textContent = securityQInputHTM.value;
  securityATargetHTM.textContent = securityAInputHTM.value;
  getRadioVal();
}
let hasSubmitted = false;

function submitRequest() {
  if (hasSubmitted) {
    confirmSubmit2()
  }
  signInForm.setAttribute("class", "box bigshadow is-size-5 has-background-white-ter");
  signInForm.setAttribute("draggable", "true");
  submitButtonHTM.innerHTML = `Confirm &nbsp<span class="icon"><i class="fas fa-check"></i></span>`;
  hasSubmitted = true;
}

function dragOver(e) {
  e.preventDefault();
}

function confirmSubmit(e) {
  e.preventDefault();
  alert("confirmed");
}

function drag(e) {

}

function confirmSubmit2() {
  const xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      if (xhr.responseText === "failed") {
        
      }
      else if (xhr.responseText) {
        console.log("======= xhr text: " + xhr.responseText);
        alert("Submitted");
        window.location.href = "http://localhost:8080/jmacias_project-1/api/Project1Servlet?option=" + xhr.responseText;
      }
      else {
        console.log("hmmm . . .");
      }
    }
  }
  const sendString = "name=" + nameInputHTM.value + "&password=" + pwInputHTM.value + "&securityq=" + securityQInputHTM.value + "&securitya=" + securityQInputHTM.value + "&role=" + roleTargetHTM.textContent + "&option=createuser";
  xhr.open("GET", "http://localhost:8080/jmacias_project-1/api/Project1Servlet?" + sendString);
  console.log(sendString);
  xhr.send();
}

document.addEventListener("keyup", updateName);
document.addEventListener("click", updateName);
submitButtonHTM.addEventListener("click", submitRequest);
dropSubmit.addEventListener("ondragover", dragOver);
dropSubmit.addEventListener("drop", confirmSubmit);