<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
    <head>
        <title>User Details</title>
        <!-- Include jQuery from a CDN -->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    </head>
    <body>
        <h2>User Dashboard</h2>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px; /* Adjust the padding to add space between columns */
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            form {
                margin-top: 20px; /* Add space above the form */
                display: table;
                width: 100%;
            }

            .form-row {
                display: table-row;
            }

            .form-group {
                display: table-cell;
                padding: 8px; /* Adjust the padding as needed */
            }

            label {
                display: block;
                margin-bottom: 5px; /* Adjust the margin as needed */
            }

            input {
                width: 100%; /* Take up the full width of the form group */
            }

            .form-group {
                margin-bottom: 15px;
            }

            label {
                font-weight: bold;
                font-size: 18px;
                display: block;
                margin-bottom: 5px;
            }

            input[type="text"] {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            input[type="email"] {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            /* Style for the details popup */
            .popup {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 20px;
                background-color: #fff;
                border: 1px solid #ccc;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                z-index: 1000;
            }

            /* Style for the Edit User details popup */
            .createuserpopup {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 20px;
                background-color: #fff;
                border: 1px solid #ccc;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                z-index: 1000;
            }

        </style>

        <!--        show user-->
        <table id="userTable">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Gender</th>
                    <th>Address</th>
                    <th>About</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
        <p style="text-align: center; margin-top: 50px; margin-bottom: 50px;">
            <button style="font-weight: bold;" onclick="openForm()">Add User</button>
        </p>

        <!--create user-->
        <div id="popupForm" style="display: none;" class="createuserpopup">
            <!-- Updated form with tabular layout -->
            <form>
                <div class="form-row">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" required><br>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" required><br>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required><br>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="text" id="phone" name="phone" required><br>
                    </div>
                </div>


                <div class="form-row">
                    <div class="form-group">
                        <label for="about">About:</label>
                        <input type="text" id="about" name="about" required><br>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <textarea id="address" name="address" required></textarea><br>
                    </div>
                    <div class="form-group">
                        <label for="activeCheckbox">Active:</label>
                        <input type="checkbox" id="activeCheckbox" onchange="updateCheckboxValue()">
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <input type="radio" id="male" name="gender" value="Male">
                        <label for="male">Male</label>
                        <input type="radio" id="female" name="gender" value="Female">
                        <label for="female">Female</label><br>
                    </div>
                </div>
                <div class="form-row">
                    <input style="font-weight: bold;" type="submit" value="Submit" onclick="createUser()">
                    <button onclick="hideEditUserDetails()">Close</button>
                </div>
            </form>
        </div>


        <div id="userDetailsPopup" class="popup">

        </div>

        <input type="text" id="hiddenforeditId" name="" value="" hidden>

        <script>
            function openForm() {
                var form = document.getElementById('popupForm');
                form.style.display = (form.style.display === 'none' || form.style.display === '') ? 'block' : 'none';
            }

            function hideEditUserDetails() {
                document.getElementById('popupForm').style.display = 'none';
            }

            var activevalue;
            function updateCheckboxValue() {
                var checkbox = document.getElementById('activeCheckbox');
                activevalue = checkbox.checked ? 1 : 0;
            }
        </script>

        <script>
            function createUser() {
                if (!validateForm()) {
                    alert("Please fill in all mandatory fields.");
                    return;
                }

                var userData = {
                    name: $("#name").val(),
                    password: $("#password").val(),
                    email: $("#email").val(),
                    address: $("#address").val(),
                    about: $("#about").val(),
                    gender: $("input[name='gender']:checked").val(),
                    phone: $("#phone").val(),
                    active: activevalue
                };

                var hiddenforeditId = $("#hiddenforeditId").val();
                if (hiddenforeditId !== "") {
                    $.ajax({
                        type: "PUT", // or "POST" depending on your API
                        url: "http://localhost:8080/EcomBack/user/updateUser/" + hiddenforeditId,
                        contentType: "application/json",
                        data: JSON.stringify(userData),
                        success: function (response) {
                            location.reload(true);
                            console.log("User updated successfully");
                        },
                        error: function (xhr, status, error) {
                            console.error("Status: " + status);
                            console.error("Error: " + error);
                            console.error(xhr);
                            alert("Error updating user");
                        }
                    });
                } else {
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "http://localhost:8080/EcomBack/user/createUser",
                        data: JSON.stringify(userData),
                        success: function (data) {
                            alert("User created successfully!");
                            location.reload(true);
                        },
                        error: function (error) {
                            alert("Error creating user!");
                            console.log(error);
                        }
                    });
                }
            }

            function validateForm() {
                return $("#name").val() && $("#password").val() && $("#email").val() &&
                        $("#address").val() && $("#about").val() && $("input[name='gender']:checked").val() &&
                        $("#phone").val();
            }
        </script>

        <script>
            $(document).ready(function () {
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/EcomBack/user/getAllUser",
                    dataType: "json",
                    success: function (response) {
                        console.log(response);
                        populateTable(response);
                    },

                    error: function (error) {
                        console.error(error);
                        alert("Error fetching user data");
                    }
                });

                function populateTable(users) {
                    var tbody = $('#userTable tbody');
                    tbody.empty();

                    $.each(users, function (index, user) {
                        var row = '<tr>' +
                                '<td>' + user.name + '</td>' +
                                '<td>' + user.email + '</td>' +
                                '<td>' + user.phone + '</td>' +
                                '<td>' + user.gender + '</td>' +
                                '<td>' + user.address + '</td>' +
                                '<td>' + user.about + '</td>' +
                                '<td><button onclick="editUser(\'' + user.userId + '\')">Edit</button>\n\n\
                                     <button onclick="deleteUser(\'' + user.userId + '\')">Delete</button>\n\n\
                                     <button onclick="showUserDetails(\'' + user.userId + '\')">Details</button></td>' +
                                '</tr>';
                        tbody.append(row);
                    });
                }
            });
        </script>

        <script>
            function showUserDetails(userId) {
                document.getElementById('userDetailsPopup').style.display = 'block';

                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/EcomBack/user/getUserById/" + userId,
                    dataType: "json", // Change the data type according to your API response
                    success: function (user) {
                        // Handle the success response
                        console.log(user.name);

                        $("#userDetailsPopup").html(
                                "<h2>User Details</h2>" +
                                "<p>Name: " + user.name + "</p>" +
                                "<p>Email: " + user.email + "</p>" +
                                "<p>phone : " + user.phone + "</p>" +
                                "<p>Gender : " + user.gender + "</p>" +
                                "<p>Address : " + user.address + "</p>" +
                                "<p>About : " + user.about + "</p>" +
                                '<button onclick="hideUserDetails()">Close</button>'
                                );
                    },
                    error: function (error) {
                        console.error(error);
                        alert("Error fetching user data");
                    }
                });
            }

            function hideUserDetails() {
                document.getElementById('userDetailsPopup').style.display = 'none';
            }

        </script>

        <script>
            function deleteUser(userId) {
                if (confirm("Are you Sure ?") === false) {
                    return;
                } else {
                    $.ajax({
                        type: "DELETE",
                        url: "http://localhost:8080/EcomBack/user/deleteUser/" + userId,
                        success: function (response) {
                            console.log("User deleted successfully");
                            location.reload(true);
                        },
                        error: function (xhr, status, error) {
                            console.error("Status: " + status);
                            console.error("Error: " + error);
                            console.error(xhr);
                            alert("Error deleting user");
                        }
                    });
                }
            }
        </script>

        <script>
            function editUser(userId) {
                document.getElementById('popupForm').style.display = 'block';
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/EcomBack/user/getUserById/" + userId,
                    dataType: "json", // Change the data type according to your API response
                    success: function (user) {
                        $("#hiddenforeditId").val(user.userId);

                        $("#name").val(user.name);
                        $("#email").val(user.email);
                        $("#phone").val(user.phone);
                        $("#address").val(user.address);
                        $("#about").val(user.about);

                        if (user.active) {
                            $("#activeCheckbox").prop("checked", user.active);
                        }
                        $('input[name=gender][value="' + user.gender + '"]').prop('checked', true);
                    },
                    error: function (error) {
                        console.error(error);
                        alert("Error fetching user data");
                    }
                });
            }
        </script>
    </body>
</html>






