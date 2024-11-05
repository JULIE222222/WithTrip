
function addRow() {
  // table element 찾기
  const table = document.getElementById('details');

  // 새 행(Row) 추가
  const newRow = table.insertRow();

  // 새 행(Row)에 Cell 추가
  const newCell1 = newRow.insertCell(0);
  const newCell2 = newRow.insertCell(1);
  const newCell3 = newRow.insertCell(2);
  const newCell4 = newRow.insertCell(3);

  // Cell에 텍스트 추가
  newCell1.innerHTML = "<input type ='time' id='detailTime' value='' />";
  newCell2.innerHTML = "<input type ='text' id='location' placeholder='여행 일정을 입력하세요.' value='' />";
  newCell3.innerHTML = "<input type ='text' id='activity' placeholder='여행 내용을 입력하세요.' value='' />";
  newCell4.innerHTML = "<input type ='text' id='price' placeholder='여행 비용을 입력하세요.' value='' />";
}