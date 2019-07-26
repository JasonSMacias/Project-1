const nameSpanHTM = document.querySelector("#welcome-username");
const logoutButtonHTM = document.querySelector("#logout-button");
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

function logOut() {
  const xhr4 = new XMLHttpRequest();

  xhr4.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {

      if (xhr4.responseText) {
        const requestObject = JSON.stringify(xhr4.responseText);
        console.log(requestObject);
      }
      else {
        console.log("hmmm . . .");
      }
    }
  }
  xhr.open("GET", "http://localhost:8080/jmacias_project-1/api/Project1Servlet?option=logout");
  xhr.send();
}

logoutButtonHTM.addEventListener("click", logOut());