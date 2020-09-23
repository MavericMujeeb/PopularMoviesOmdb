It is a Test Application

Objective :

1. Movies List Screen:
   a. The user should be able to enter the movie title to search for
   b. The list needs to be scrollable and when the user reach the end of the screen, it should
      fetch the next set of results if there is any.
   c. Please refer to the attached wireframe for the UI.
   d. The movie list can be fetched from the OMDb. For example, the following request will
      fetch list of movies with title as “Marvel”
      http://www.omdbapi.com/?apikey=b9bd48a6&s=Marvel&type=movie
   e. Tapping on a movie should take the user to Movie Details screen.
2. Movie Details Screen:
   a. The movie details can be fetched from OMDb. For example, to get movie details
   http://www.omdbapi.com/?apikey=b9bd48a6&i=tt4154664
   b. The user should be able to navigate back to the Movies List screen.
   c. Please refer to the attached wireframe for the UI.
   
Steps to Manual UI testing :

1. Open the app then click on the search bar at the top.

2. Type the name of the movie you want to search.

3. Two scenarios can happen, either there will no movie with that name in which case a toast will be shown stating "No results found" or the list of movies or a movie will be displayed.

4. Clicking on any movie will take you to the details page.

5. In details page all the details regarding the movie would be shown.

6. On click of back button it will come back to MainActivity where the list of the movies will be displayed.

7. On further click of back button app will exit.


Below are the screenshots :

https://github.com/kunal261993/MovieApp/blob/master/Screenshot_20200915-225538.jpg

https://github.com/kunal261993/MovieApp/blob/master/Screenshot_20200915-225710.jpg


