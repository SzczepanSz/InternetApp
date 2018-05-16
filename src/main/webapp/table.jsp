<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="jquery.restable.min.js"></script>
<link rel="stylesheet" href="jquery.restable.min.css">


<table class="mytable">
    <thead>
    <tr>
        <td>Period</td>
        <td>Full Board</td>
        <td>Half Board</td>
        <td>Bed and Breakfast</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>01/10/12 - 02/10/12</td>
        <td>20 €</td>
        <td>30 €</td>
        <td>40 €</td>
    </tr>
    <tr>
        <td>03/10/12 - 04/10/12</td>
        <td>40 €</td>
        <td>50 €</td>
        <td>60 €</td>
    </tr>
    <tr>
        <td>05/10/12 - 06/10/12</td>
        <td>70 €</td>
        <td>80 €</td>
        <td>90 €</td>
    </tr>
    </tbody>
</table>

$(document).ready(function () {
$.ReStable();
});

$(document).ready(function () {
$('.mytable').ReStable();
});

$('.mytable').ReStable({
rowHeaders: true, // Table has row headers?
maxWidth: 480, // Size to which the table become responsive
keepHtml: false // Keep the html content of cells
});
