import React from "react";

function Home() {
  return (
    <div className="about" style={{marginLeft: "402px", marginRight: "30px", marginTop: "100px"}}>
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-4">
            <div class="profileCard">
              <div class="profilePicture"></div>
              <div class="profileHeader">
                <div class="profileName">John Doe</div> 
                <div class="profileTitle">Research Assistant</div>
              </div>
            </div>
          </div>
          <div class="col-lg-8">
            <div class="col-lg-6">
              <div class="defaultCard">
                <div class="cardTitle">
                  <font color="#4059A8">Assigned</font> Activities
                </div>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.<br></br>
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
              </div>
            </div>
            <div class="col-lg-6">
              <div class="defaultCard">
                <div class="cardTitle">
                <font color="#E96262">Unassigned</font>  Activities
                </div>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.<br></br>
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
