$( document ).ready(function() {
    const editComputerModal = $('#editComputerModal');
    editComputerModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const computerId = $(button).data('computerId');
        const computerManufacturer = $(button).data('computerManufacturer');
        const computerModel = $(button).data('computerModel');
        const computerSerialNumber = $(button).data('computerSerialNumber');
        const computerCpu = $(button).data('computerCpu');
        const computerRam = $(button).data('computerRam');
        const computerOs = $(button).data('computerOs');

        $('#inputEditComputerId').val(computerId);
        $('#inputEditComputerManufacturer').val(computerManufacturer);
        $('#inputEditComputerModel').val(computerModel);
        $('#inputEditComputerSerialNumber').val(computerSerialNumber);
        $('#inputEditComputerCpu').val(computerCpu);
        $('#inputEditComputerRam').val(computerRam);
        $('#inputEditComputerOs').val(computerOs);
    });

    const deleteComputerModal = $('#deleteComputerModal');
    deleteComputerModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const computerId = $(button).data('computerId');

        $('#inputDeleteComputerId').val(computerId);
    });

    const editMonitorModal = $('#editMonitorModal');
    editMonitorModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const monitorId = $(button).data('monitorId');
        const monitorManufacturer = $(button).data('monitorManufacturer');
        const monitorModel = $(button).data('monitorModel');
        const monitorSerialNumber = $(button).data('monitorSerialNumber');
        const monitorScreenSize = $(button).data('monitorScreenSize');
        const monitorResolution = $(button).data('monitorResolution');

        $('#inputEditMonitorId').val(monitorId);
        $('#inputEditMonitorManufacturer').val(monitorManufacturer);
        $('#inputEditMonitorModel').val(monitorModel);
        $('#inputEditMonitorSerialNumber').val(monitorSerialNumber);
        $('#inputEditMonitorScreenSize').val(monitorScreenSize);
        $('#inputEditMonitorResolution').val(monitorResolution);
    });

    const deleteMonitorModal = $('#deleteMonitorModal');
    deleteMonitorModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const monitorId = $(button).data('monitorId');

        $('#inputDeleteMonitorId').val(monitorId);
    });

    const editCompanyPhoneModal = $('#editCompanyPhoneModal');
    editCompanyPhoneModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const companyPhoneId = $(button).data('companyPhoneId');
        const companyPhoneManufacturer = $(button).data('companyPhoneManufacturer');
        const companyPhoneModel = $(button).data('companyPhoneModel');
        const companyPhoneSerialNumber = $(button).data('companyPhoneSerialNumber');
        const companyPhoneNumber = $(button).data('companyPhoneNumber');

        $('#inputEditCompanyPhoneId').val(companyPhoneId);
        $('#inputEditCompanyPhoneManufacturer').val(companyPhoneManufacturer);
        $('#inputEditCompanyPhoneModel').val(companyPhoneModel);
        $('#inputEditCompanyPhoneSerialNumber').val(companyPhoneSerialNumber);
        $('#inputEditCompanyPhonePhoneNumber').val(companyPhoneNumber);
    });

    const deleteCompanyPhoneModal = $('#deleteCompanyPhoneModal');
    deleteCompanyPhoneModal.on('show.bs.modal', function (event) {
        const button = event.relatedTarget;

        const companyPhoneId = $(button).data('companyPhoneId');

        $('#inputDeleteCompanyPhoneId').val(companyPhoneId);
    });
});