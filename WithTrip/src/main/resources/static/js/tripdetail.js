
/*//여행계획 리스트 추가함수
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
}*/

  // DB에서 받아온 여행 계획의 시작일과 종료일
         const startDate = new Date('2024-11-13');  // 예시: tripplan.starttime
         const endDate = new Date('2024-11-15');    // 예시: tripplan.endtime

         // 일정 생성 함수
         function generateSchedule() {
             const tableBody = document.querySelector('#trip-plan-body');
             tableBody.innerHTML = ''; // 기존 내용을 지웁니다.

             // 날짜 차이 계산
             const timeDifference = endDate - startDate;
             const daysDifference = timeDifference / (1000 * 3600 * 24); // 날짜 차이 계산

             // 시작 날짜에서부터 끝 날짜까지 반복하여 각 날짜에 해당하는 테이블 생성
             for (let i = 0; i <= daysDifference; i++) {
                 const currentDate = new Date(startDate);
                 currentDate.setDate(startDate.getDate() + i); // 현재 날짜 설정

                 // 테이블 행 생성 (DAY1, DAY2, DAY3 등)
                 const row = document.createElement('tr');
                 const dateCell = document.createElement('td');
                 dateCell.textContent = `DAY ${i + 1} (${currentDate.toISOString().split('T')[0]})`;

                 // 각 날짜에 대해 시간 테이블을 추가할 수 있는 버튼을 생성
                 const addButtonCell = document.createElement('td');
                 const addButton = document.createElement('button');
                 addButton.textContent = '시간 테이블 추가';
                 addButton.onclick = function () { addTimeTable(i); };
                 addButtonCell.appendChild(addButton);

                 // 행에 셀 추가
                 row.appendChild(dateCell);
                 row.appendChild(addButtonCell);

                 // 각 날짜별로 테이블을 추가
                 tableBody.appendChild(row);
             }
         }

         // 시간 테이블을 추가하는 함수
         function addTimeTable(dayIndex) {
             // 각 날짜별로 동적으로 테이블을 생성합니다.
             const timeTable = document.createElement('table');
             timeTable.classList.add('table1');

             const headerRow = document.createElement('tr');
             headerRow.innerHTML = '<th>Time</th><th>일정</th><th>내용</th><th>비용</th>';
             timeTable.appendChild(headerRow);

             // 시간 테이블에 기본 행 추가
             const timeRow = document.createElement('tr');
             timeRow.innerHTML = `
                 <td><input type="time" id="detailTime-${dayIndex}"></td>
                 <td><input type="text" id="location-${dayIndex}" placeholder="여행 일정을 입력하세요."></td>
                 <td><input type="text" id="activity-${dayIndex}" placeholder="여행 내용을 입력하세요."></td>
                 <td><input type="text" id="price-${dayIndex}" placeholder="여행 비용을 입력하세요."></td>
             `;
             timeTable.appendChild(timeRow);

             // 해당 날짜의 행에 시간 테이블 추가
             const row = document.querySelectorAll('#trip-plan-body tr')[dayIndex];
             row.appendChild(timeTable);
         }

         // 페이지가 로드될 때 자동으로 여행 일정 생성
         window.onload = generateSchedule;