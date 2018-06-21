function openModal(buttonId) {
  var modalFilePath;

  switch (buttonId) {
    case "open-add-mentor-modal":
      modalFilePath = "../../add_mentor_modal.html";
      break;
    case "open-edit-mentor-modal":
      modalFilePath = "../../edit_mentor_modal.html";
      break;
    case "open-remove-mentor-modal":
      modalFilePath = "../../remove_mentor_modal.html";
      break;
    case "open-add-class-modal":
      modalFilePath = "../../add_class_modal.html";
      break;
    case "open-add-codecooler-modal":
      modalFilePath = "../../add_codecooler_modal.html";
      break;
    case "open-edit-codecooler-modal":
      modalFilePath = "../../edit_codecooler_modal.html";
      break;
    case "open-remove-codecooler-modal":
      modalFilePath = "../../remove_codecooler_modal.html";
      break;
    case "open-add-artifact-modal":
      modalFilePath = "../../add_artifact_modal.html";
      break;
    case "open-edit-artifact-modal":
      modalFilePath = "../../edit_artifact_modal.html";
      break;
    case "open-remove-artifact-modal":
      modalFilePath = "../../remove_artifact_modal.html";
      break;
    case "open-add-quest-modal":
      modalFilePath = "../../add_quest_modal.html";
      break;
    case "open-edit-quest-modal":
      modalFilePath = "../../edit_quest_modal.html";
      break;
    case "open-remove-quest-modal":
      modalFilePath = "../../remove_quest_modal.html";
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

async function openModal(buttonId, button) {
  var modalFilePath;
  var fillingFunction;

  var element = document.getElementById("common-modal").querySelector(".modal-content");

  var entityId = button.dataset.id;

  switch (buttonId) {
    case "open-buy-artifact-modal":
      element.innerHTML = await addBuyArtifactModal(entityId);
      break;
  }

  $('#common-modal').modal('show');

  return;
}

async function addBuyArtifactModal(id) {
  var artifactData = await getJsonFromPath("http://127.0.0.1:8080/artifacts/" + id);
  var artifactData = artifactData.artifacts[0];

  var filledModal =
  '<div class="modal-header">' +
  '  <h5 class="modal-title">Buy artifact</h5>' +
  '  <button type="button" class="close" data-dismiss="modal" aria-label="Close">' +
  '    <span aria-hidden="true">&times;</span>' +
  '  </button>' +
  '</div>' +
  '<div class="modal-body">' +
  '  <p>Do you really want to buy ' + artifactData.name + '?</p>' +
  '</div>' +
  '<div class="modal-footer">' +
  '  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>' +
  '  <button type="submit" class="btn btn-success" data-id="' + artifactData.id + '" onclick="buyArtifact(this); javascript:window.location.reload()">Buy</button>' +
  '</div>';

  return filledModal;
}