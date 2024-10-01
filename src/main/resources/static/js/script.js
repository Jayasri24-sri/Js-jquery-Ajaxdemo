$(document).ready(function()
{
    $("#movieForm").on("submit", function(event)
    {
        event.preventDefault();
        const title = $("#title").val();
        const rating = $("#rating").val();
        $.ajax(
            {
            type: "POST",
            url: "/api/movies",
            data: JSON.stringify(rating),
            contentType: "application/json",
            success: function()
            {
                $("#successMessage").text(`Successfully submitted "${title}" with rating ${rating}.`);

                $.ajax(
                    {
                    type: "GET",
                    url: "/api/movies/average",
                    success: function(average)
                    {
                        $("#averageRating").text(average.toFixed(1));
                    }
                });

                $("#title").val("");
                $("#rating").val("");
            },
            error: function(xhr)
            {
                console.error("Error:", xhr.responseText);
            }
        });
    });
});
