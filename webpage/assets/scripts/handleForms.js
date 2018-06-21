function handleEditLevelForm(form) {
  var elementId = form.dataset.id;

  var inputs = form.getElementsByTagName("input");

  var name = inputs[0].value;
  var threshold = inputs[1].value;

  levelData = {
    "id": elementId,
    "name": name,
    "threshold": threshold
  }

  console.log(JSON.stringify(levelData));

  var url = 'http://127.0.0.1:8080/levels/' + elementId;

  fetch(url, {
    method: 'PUT',
    body: JSON.stringify(levelData),
    headers:{
      'Content-Type': 'application/json'
    }
  });

  $('#common-modal').modal('hide');

  return false;
}

function deleteLevel(deleteButton) {
  var elementId = deleteButton.dataset.id;

  var url = 'http://127.0.0.1:8080/levels/' + elementId;

  fetch(url, {
    method: 'DELETE',
  });

  $('#common-modal').modal('hide');

  return false;
}