jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = "/hms/departments?branchId="
            + $(this).closest("tr").find("td:eq(6)").text();
    });
});
