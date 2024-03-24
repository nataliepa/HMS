jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = "/hms/workstations?branchId="
            + $(this).closest("tr").find("td:eq(2)").text()
            + "&departmentId="
            + $(this).closest("tr").find("td:eq(3)").text();
    });
});