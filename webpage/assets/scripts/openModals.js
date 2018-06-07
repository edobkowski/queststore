function openModal(buttonId) {
  var modalFilePath;

  switch (buttonId) {
    case "open-add-mentor-modal":
      modalFilePath = "assets/modals/add_mentor_modal.html";
      break;
    case "open-edit-mentor-modal":
      modalFilePath = "assets/modals/edit_mentor_modal.html";
      break;
    case "open-remove-mentor-modal":
      modalFilePath = "assets/modals/remove_mentor_modal.html";
      break;
    case "open-add-class-modal":
      modalFilePath = "assets/modals/add_class_modal.html";
      break;
    case "open-edit-class-modal":
      modalFilePath = "assets/modals/edit_class_modal.html";
      break;
    case "open-remove-class-modal":
      modalFilePath = "assets/modals/remove_class_modal.html";
      break;
    case "open-add-level-modal":
      modalFilePath = "assets/modals/add_level_modal.html";
      break;
    case "open-edit-level-modal":
      modalFilePath = "assets/modals/edit_level_modal.html";
      break;
    case "open-remove-level-modal":
      modalFilePath = "assets/modals/remove_level_modal.html";
      break;
  }
  
  var element = document.getElementById("common-modal").querySelector(".modal-content");

  var request = new XMLHttpRequest();
  request.onreadystatechange = function() {
    if (this.readyState == 4) {
      if (this.status == 200) {
        element.innerHTML = this.responseText;
        $('#common-modal').modal('show');
      }
      if (this.status == 404) {
        element.innerHTML = "Page not found.";
      }
    }
  } 
  request.open("GET", modalFilePath, true);
  request.send();
  
  return;
}