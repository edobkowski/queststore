function buyArtifact(deleteButton) {
  var elementId = deleteButton.dataset.id;

  var url = 'http://127.0.0.1:8080/artifacts/' + elementId;

  fetch(url, {
    method: 'POST',
  });

  $('#common-modal').modal('hide');

  return false;
}