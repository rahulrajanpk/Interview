# Interview

<h2>Introduction</h2>

A library is to be build to do the following task
 <ul>
  <li>	Display cheapest of each car type</li>
  <li>Allow to pass filter by car type</li>
  <li>Sort by corporate (Corporate Cars are AVIS,BUDGET,ENTERPRISE,FIREFLY,HERTZ,SIXT,THRIFTY) </li>
  <li>	Within each group sort low-to-high price</li>
  </ul>


<h2>Working thought process</h2>

  <ul>
  <li> <b>For code confidentiality on GITHUB all @ symbol was removed from the JSON repsonse</b></li>
    <li>For Unit Test, Object Mapper is preferred but since no class code was provided hence <b>Rest Assured</b> and <b>Gpath</b> was used for extration of the JSON data</li>
    <li><b>Rest Assured</b> and <b>Gpath</b> expect a response from the API hence mock API was created for building library</li>
    <li>It is expected that the call to the library will be made from the <b>Main class</b> <code>CarTrawler\src\main\java\interview.java</code></li>
    <li>All library function are in <code>CarTrawler\src\main\java\Library\UtilLib.java</code></li>
     <li>Since it is not being specified that what should be the type of the output hence assumption were made as per parsing</li>

</ul>
      
<h2>Assumption:</h2>
      <h3>Display cheapest of each car type</h3>
  <ul>
    <li><b>Understanding</b> Display the list of cheapest <b>[RateTotalAmount]</b> for the car <b>[VehMakeModel]</b></li>
    <li><b>Function name</b> getCheapestCarList()</li>
    <li><b>Function parameter</b> JSON response</li>

</ul>
  <h3>Allow to pass filter by car type</h3>
  <ul>
  <li><b>Understanding</b> Depending on the <b>[TransmissionType]</b> passed by user, display the list of vechicles</li>
    <li><b>Function name</b> getVehiclesByType()</li>
    <li><b>Function parameter</b> JSON response and transmission type </li>


</ul>
      <h3>Display cheapest of each car type</h3>
  <ul>
    <li><b>Understanding</b> Provide the list of sorted vendors belonging to corporate <b>[DIVISION]</b></li>
    <li><b>Function name</b> sortByCorporate</li>
   <li><b>Function parameter</b> JSON response and list of corporate division </li>


</ul>
      <h3>Within each group sort low-to-high price</h3>
  <ul>
  <li><b>Understanding</b> Within each <b>[VehVendorAvails]</b> list sort and display the <imp>[RateTotalAmount]</b></li>
    <li><b>Function name</b> sortByPriceInGroup</li>
  <li><b>Function parameter</b> JSON response </li>

</ul>

<h2> How to run</h2>
It is normal maven project call any library function from main by providing the response as parameter 
  
