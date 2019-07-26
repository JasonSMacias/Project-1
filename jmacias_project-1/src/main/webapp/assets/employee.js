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
const mainBox = document.querySelector("#main-box");


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

function submitRequest() {
  console.log("submitRequest ran");
  for (let x of hideableNList) {
    x.setAttribute("style", "display: none");
  }
  hiddenSubmit.setAttribute("style", "");
}

function uploadReceipt() {

}

submitRequestHTM.addEventListener("click", activatePanel);
submitRequestHTM.addEventListener("click", submitRequest);

uploadReceiptHTM.addEventListener("click", activatePanel);
uploadReceiptHTM.addEventListener("click", uploadReceipt);

viewPendingHTM.addEventListener("click", activatePanel);
viewResolvedHTM.addEventListener("click", activatePanel);
viewInfoHTM.addEventListener("click", activatePanel);
updateInfoHTM.addEventListener("click", activatePanel);
