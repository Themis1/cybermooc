function showInfo() {
    var d = new Date(2020, 1, 11, 21, 00);
    var name = document.getElementById("name").value
    alert("You have signed up to the event with the following \n\
            information: "  + "\n" + 
            "Event: Unicorn league extragavanza "  + "\n" + 
            "Date: " + d  + "\n" + "Dress attire: Formal "
            + "\n" +  "Participant: " + name)
}
