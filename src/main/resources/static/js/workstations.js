jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = "/hms/equipment?branchId="
            + $(this).closest("tr").find("td:eq(6)").text()
            + "&departmentId="
            + $(this).closest("tr").find("td:eq(7)").text()
            + "&workstationId="
            + $(this).closest("tr").find("td:eq(8)").text();
    });
});