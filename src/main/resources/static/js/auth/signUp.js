$(() => {
  $('#register').on('click', function (e) {
  });
  $('#pw').on('focusout', function (e) {
    check_pw(e);
  })
  $('#pw2').on('focusout', function (e) {
    check_pw(e);
  })

  function check_pw(e) {
    let pw = $('#pw').val();
    let pw2 = $('#pw2').val();
    const SC = ["!", "@", "#", "$", "%"];
    let check_SC = 0;

    if (pw.length < 6 || pw.length > 16) {
      Swal.fire({
        text: '비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.',
        showClass: {
          popup: '',
        },
        hideClass: {
          popup: '',
        },
        allowOutsideClick: false
      }).then((result) => {
        if (!result.isConfirmed || result.isConfirmed) {
          $(e.target).focus();
          return false;
        }
      });
      $('#pw').val('');
    }
    for (var i = 0; i < SC.length; i++) {
      if (pw.indexOf(SC[i]) !== -1) {
        check_SC = 1;
      }
    }
    if (check_SC === 0) {
      Swal.fire({
        text: '!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.',
        showClass: {
          popup: '',
        },
        hideClass: {
          popup: '',
        },
        allowOutsideClick: false
      }).then((result) => {
        if (!result.isConfirmed || result.isConfirmed) {
          $('#pw').val('').focus();
          return false;
        }
      });
    }
    const checkEl = $('#check');
    if (pw !== '' && pw2 !== '') {
      if (pw === pw2) {
        checkEl.removeClass('d-none').text('일치').attr('style', 'color: green');
      } else {
        Swal.fire({
          text: "비밀번호가 일치하지 않습니다. 다시 입력해주세요",
          showClass: {
            popup: '',
          },
          hideClass: {
            popup: '',
          },
          allowOutsideClick: false
        }).then((result) => {
          if (!result.isConfirmed || result.isConfirmed) {
            $('#pw2').val('').focus();
            checkEl.removeClass('d-none').text('비밀번호 불일치').attr('style', 'color: red');
            return false;
          }
        });
      }
    }
  }
})