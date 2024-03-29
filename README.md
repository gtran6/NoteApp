## Note App
---
Note Demo using MVVM, RoomDB and Navigation Component

## Phone Display
<img src="https://github.com/gtran6/Calculator/assets/78507684/4d0516f9-eaa2-46c0-a794-5e13e467154a" width="30%" height="30%">&ensp;<img src="https://github.com/gtran6/Calculator/assets/78507684/18798d90-49ab-4310-839d-b2f7233c1474" width="30%" height="30%">&ensp;<img src="https://github.com/gtran6/Calculator/assets/78507684/4c7ebdfc-d2cb-41e9-bcdd-995e82698a24" width="30%" height="30%">&ensp;
<img src="https://github.com/gtran6/Calculator/assets/78507684/be6a3ede-b6ea-4bf1-8030-fc08c37af6cb" width="30%" height="30%">&ensp;<img src="https://github.com/gtran6/Calculator/assets/78507684/2f3309d0-c2cb-42aa-8d97-ad21b33e4f24" width="30%" height="30%">

## Features
The Note App is an Android application developed in Kotlin using the MVVM (Model-View-ViewModel) architecture. It allows users to create, edit, delete, search, and prioritize notes. The app provides a user-friendly interface for managing notes efficiently.
- Create new notes: Users can create new notes by providing a title and content for the note.
- Edit notes: Existing notes can be edited to update the title and content.
- Delete notes: Users can delete unwanted notes to declutter their note collection.
- Search for notes: The app offers a search functionality to find specific notes based on keywords.
- Filter notes by priority: Users can assign one of five priority levels to their notes (e.g., Critical, High, Medium, Low, Routine) and filter notes based on these priorities.
- Prioritize notes by colors: Users can assign colors (e.g., orange, blue, pink, green, peach) to visually prioritize their notes.

## Tech Stacks
- Kotlin: The app is developed using the Kotlin programming language.
- Android SDK: It utilizes the Android SDK for building the user interface and interacting with device features.
- MVVM Architecture: The app follows the MVVM (Model-View-ViewModel) architectural pattern, separating the business logic from the UI.
- Room Database: The app utilizes the Room Persistence Library for managing the SQLite database and data access.
- LiveData: The app uses LiveData for observing and updating data between the ViewModel and UI components.
- ViewModel: The ViewModel provides the data and logic for the UI and handles communication with the repository.
- Repository: The repository acts as a single source of truth for data, abstracting data sources and providing clean APIs for the ViewModel.
- Coroutines: The app employs Coroutines for managing asynchronous tasks and background operations.

## Usage
- Launch the Note App on your device.
- To create a new note, click on the "New Note" button and enter the title and content for the note.
- To edit an existing note, select the note from the list and click on the note.
- To delete a note, select the note from the list and click on the "Delete" button.
- To search for a specific note, use the search bar and enter keywords related to the note.
- To filter notes by priority, use the priority filter options available.
- To prioritize notes using colors, select a note and choose a color to assign to it.
