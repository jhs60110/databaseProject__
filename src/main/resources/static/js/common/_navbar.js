// $().ready(function () {
//     $('#navRestart').click(function () {
//         Swal.fire({
//             title: '진단을 새로 시작하시겠습니까?',
//             text: "기존에 저장되어있던 응답값은 삭제됩니다.",
//             icon: 'warning',
//             showCancelButton: true,
//             confirmButtonColor: '#3085d6',
//             cancelButtonColor: '#d33',
//             confirmButtonText: '재시작',
//             cancelButtonText: '취소'
//         }).then((result) => {
//             if (result.isConfirmed) {
//                 Swal.fire(
//                     '자가진단을 새로 시작합니다.',
//                     '기존 데이터는 삭제되었습니다.',
//                     'success'
//                 ).then((result) => {
//                     if(result.isConfirmed){
//                         location.href = _ctx + 'survey/restart'
//                     }
//                 })
//             }
//         })
//     });
//
//     $('#navSubmit').click(function () {
//         Swal.fire({
//             title: '진단을 새로 시작하시겠습니까?',
//             text: "기존에 저장되어있던 응답값은 삭제되며, 제출 전까지 통계페이지를 이용하실 수 없습니다.",
//             icon: 'warning',
//             showCancelButton: true,
//             confirmButtonColor: '#3085d6',
//             cancelButtonColor: '#d33',
//             confirmButtonText: '시작',
//             cancelButtonText: '취소'
//         }).then((result) => {
//             if (result.isConfirmed) {
//                 Swal.fire(
//                     '자가진단을 새로 시작합니다.',
//                     '기존 데이터는 삭제되었습니다.',
//                     'success'
//                 ).then((result) => {
//                     if(result.isConfirmed){
//                         location.href = _ctx + 'survey/restart'
//                     }
//                 })
//             }
//         })
//     });
// });
