$( document ).ready(function() {
    const editModal = $('#editModal');
    editModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const userId = $(button).data('userId');
        const userUsername = $(button).data('userUsername');
        const userLastname = $(button).data('userLastname');
        const userFirstname = $(button).data('userFirstname');
        const userRoleId = $(button).data('userRoleId');
        const userBranchId = $(button).data('userBranchId');

        $('#idUpd').val(userId);
        $('#usernameUpd').val(userUsername);
        $('#lastNameUpd').val(userLastname);
        $('#firstNameUpd').val(userFirstname);
        $('#roleUpd').val(userRoleId);
        $('#branchUpd').val(userBranchId);
    });

    const deleteModal = $('#deleteModal');
    deleteModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const userId = $(button).data('userId');

        $('#inputDeleteUserId').val(userId);
    });
});