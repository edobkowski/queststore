const sectionHeader = "<hr>" +
            "<h3>List of classes</h3>";
            
const tableStructure = "<table class=\"table w-25\">" + 
						"	<thead class=\"thead-dark\">" + 
						"		<tr>" + 
						"			<th></th>" + 
						"			<th>Name</th>" + 
						"			<th></th>" + 
						"		</tr>" + 
            "	</thead>" +
            " <tbody>" +
            " </tbody>" +
            "</table>";


async function createTableFromJson(jsonPath) {
    const classesTableDiv = document.getElementById("classes-table");
    const classesJson = await getJsonFromPath(jsonPath);

    if (classesJson.classes.length === 0) {
      return null;
    } 

    classesTableDiv.innerHTML = sectionHeader + tableStructure;
    addRows(classesJson, classesTableDiv);
}

async function getJsonFromPath(path) {
    const response = await fetch(path);
    return response.json();
}


function addRows(classesJson, classesDiv) {
  const classesTableBody = classesDiv.querySelector("tbody");

  for (let i = 0; i < classesJson.classes.length; i++) {
    const codecoolClass = classesJson.classes[i];
    const filledRow = '<tr>' +
      '  <td>' + (i + 1) + '</td>' +
      '  <td>' + codecoolClass.name + '</td>' +
      '  <td class="center-column">' +
      '    <i class="fas fa-pencil-alt" id="open-edit-class-modal" onclick="openModal(this.id)"></i>' +
      '    <i class="fas fa-trash-alt" id="open-remove-class-modal" onclick="openModal(this.id)"></i>' +
      '  </td>' +
      '</tr>';

      classesTableBody.innerHTML += filledRow;
  }
}

createTableFromJson("../../more_classes.json");