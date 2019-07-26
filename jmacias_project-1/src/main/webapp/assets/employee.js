const nameSpanHTM = document.querySelector("#welcome-username");
const submitRequestHTM = document.querySelector("#submit-request");
const uploadReceiptHTM = document.querySelector("#upload-receipt");
const viewPendingHTM = document.querySelector("#view-pending");
const viewResolvedHTM = document.querySelector("#view-resolved");
const viewInfoHTM = document.querySelector("#view-info");
const updateInfoHTM = document.querySelector("#update-info");
const panelNList = document.getElementsByClassName("panel-block");
const hideableNList = document.getElementsByClassName("hideable");
const hiddenSubmit = document.querySelector("#hidden-submit-request");
const requestSubmit = document.querySelector("#request-submit");
const valueInput = document.querySelector("#value-input");
const descriptionInput = document.querySelector("#description-input");
const dateInput = document.querySelector("#date-input");
const mainBox = document.querySelector("#main-box");
const requestDisplay = document.querySelector("#request-display");


const xhr = new XMLHttpRequest();
let username;
xhr.onreadystatechange = function () {
  if (this.readyState == 4 && this.status == 200) {

    if (xhr.responseText) {
      username = xhr.responseText;
      nameSpanHTM.textContent = username;
    }
    else {
      console.log("hmmm . . .");
    }
  }
}
xhr.open("GET", "http://localhost:8080/jmacias_project-1/api/Project1Servlet?option=getuser");
xhr.send();

function activatePanel() {
  // to activate bulma panel via JS, first clearing all active nodes on click, then activating this
  for (let x of panelNList) {
    x.setAttribute("class", "panel-block");
  }
  this.setAttribute("class", "panel-block is-active");
}

function submitRequestBegin() {
  console.log("submitRequest ran");
  for (let x of hideableNList) {
    x.setAttribute("style", "display: none");
  }
  hiddenSubmit.setAttribute("style", "");
}

function submitRequestFinal(e) {
  e.preventDefault();
  const value = valueInput.value;
  const description = descriptionInput.value;
  const date = dateInput.value;
  // const rRequestObject = {
  //   // service refers to service class to forward to, shorthand syntax for rest
  //   value,
  //   description,
  //   date
  // }
  // console.log("request object" + JSON.stringify(rRequestObject));
  console.log(`value: ${value} - description: ${description} - date: ${date}`);
  const xhr2 = new XMLHttpRequest();
  
  xhr2.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {

      if (xhr.responseText) {
        
      }
      else {
        console.log("hmmm . . .");
      }
    }
  }
  xhr.open("POST", "http://localhost:8080/jmacias_project-1/api/Project1Servlet");
  xhr.send("value=" + value + "&description=" + description + "&date=" + date + "&option=addrequest");
  alert(`Request for reimbursement of ${value} dollars for ${description} on ${date}`);
}

function uploadReceipt() {

}
function viewPending() {
    console.log("viewPending ran");
  for (let x of hideableNList) {
    x.setAttribute("style", "display: none");
  }
  requestDisplay.setAttribute("style", "");

 const xhr3 = new XMLHttpRequest();
  
  xhr3.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {

      if (xhr3.responseText) {
        const requestObject = JSON.stringify(xhr3.responseText);
        console.log(requestObject);
      }
      else {
        console.log("hmmm . . .");
      }
    }
  }
  xhr.open("GET", "http://localhost:8080/jmacias_project-1/api/Project1Servlet?option=displaypending");
  xhr.send();
  

}

submitRequestHTM.addEventListener("click", activatePanel);
submitRequestHTM.addEventListener("click", submitRequestBegin);

uploadReceiptHTM.addEventListener("click", activatePanel);
uploadReceiptHTM.addEventListener("click", uploadReceipt);

viewPendingHTM.addEventListener("click", activatePanel);
viewPendingHTM.addEventListener("click", viewPending);


viewResolvedHTM.addEventListener("click", activatePanel);
viewInfoHTM.addEventListener("click", activatePanel);
updateInfoHTM.addEventListener("click", activatePanel);

requestSubmit.addEventListener("click", submitRequestFinal);