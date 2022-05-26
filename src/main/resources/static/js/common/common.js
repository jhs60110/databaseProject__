$(() => {
  const swal = {
    textAlert : function (text) {
      Swal.fire({
        text: text,
        showClass: {
          popup:'',
        },
        hideClass: {
          popup:'',
        },
        allowOutsideClick: false
      }).then((result) => {
        if (!result.isConfirmed || result.isConfirmed) {
          $('#create-unitCost').focus();
        }
      });
    },
    titleAndText : function (title, text) {
      Swal.fire({
        title : title,
        text: text,
        showClass: {
          popup:'',
        },
        hideClass: {
          popup:'',
        },
        allowOutsideClick: false
      }).then((result) => {
        if (!result.isConfirmed || result.isConfirmed) {
        }
      });
    }
  }
});