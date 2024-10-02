$(document).ready(function () {
    function loadMovies() {
        $.ajax({
            type: "GET",
            url: "/api/movies",
            success: function (movies)
            {
                let movieList = $("#movieList");
                movieList.empty();
                movies.forEach(function (movie)
                {
                    movieList.append(`
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.rating}</td>
                            <td>
                                <button class="edit" data-id="${movie.id}">Edit</button>
                                <button class="delete" data-id="${movie.id}">Delete</button>
                            </td>
                        </tr>
                    `);
                });
            }
        });
    }
    loadMovies();
    $("#movieForm").on("submit", function (event)
    {
        event.preventDefault();
        const title = $("#title").val();
        const rating = $("#rating").val();
        const movie = { title: title, rating: parseInt(rating)};

        $.ajax({
            type: "POST",
            url: "/api/movies",
            data: JSON.stringify(movie),
            contentType: "application/json",
            success: function () {
                $("#successMessage").text(`Successfully submitted "${title}" with rating ${rating}.`);
                loadMovies(); // Reload movie list after submission
                $("#title").val("");
                $("#rating").val("");
            }
        });
    });


    $(document).on("click", ".delete", function ()
    {
        const movieId = $(this).data("id");

        $.ajax({
            type: "DELETE",
            url: `/api/movies/${movieId}`,
            success: function () {
                loadMovies();
            }
        });
    });


    $(document).on("click", ".edit", function ()
    {
        const movieId = $(this).data("id");
        const newTitle = prompt("Enter new title:");
        const newRating = prompt("Enter new rating (1-5):");

        if (newTitle && newRating)
        {
            const updatedMovie = { title: newTitle, rating: parseInt(newRating) };

            $.ajax(
                {
                type: "PUT",
                url: `/api/movies/${movieId}`,
                data: JSON.stringify(updatedMovie),
                contentType: "application/json",
                success: function ()
                {
                    loadMovies();
                }
            });
        }
    });
});
