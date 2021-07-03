import React from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import SideNav, { Toggle, Nav, NavItem, NavIcon, NavText } from '@trendmicro/react-sidenav';
import './index.css';
// Be sure to include styles at some point, probably during your bootstraping
import '@trendmicro/react-sidenav/dist/react-sidenav.css';
import Home from './home';
import Tasks from './tasks';
import Calendar from './calendar';
import logo from './napier.png';
function App() {
  return (
    <div className="App">
      <Router>
    <Route render={({ location, history }) => (
        <React.Fragment>
            <SideNav style={{backgroundColor: '#4059A8'}}
                onSelect={(selected) => {
                    const to = '/' + selected;
                    if (location.pathname !== to) {
                        history.push(to);
                    }
                }}
            >
                <SideNav.Toggle/>
                <SideNav.Nav defaultSelected="home">
                <NavItem eventKey="" style={{ width: '372px', paddingBottom : '160px', paddingTop : '50px'}}>
                        <center><img src={logo} style={{ width: '372px', paddingBottom: '500px'}}>
                        </img></center>

                    </NavItem>

                    <NavItem eventKey="home" style={{paddingBottom : '50px'}}>
                        <NavIcon>
                            <i className="fa fa-fw fa-home" style={{ fontSize: '25px', fontFamily: 'Montserrat'}} />
                        </NavIcon>
                        <NavText style={{fontSize: '25px', fontFamily: 'Montserrat'}}>
                            Dashboard
                        </NavText>
                    </NavItem>
                    <NavItem eventKey="tasks" style={{paddingBottom : '50px'}}>
                        <NavIcon>
                            <i className="fa fa-fw fa-device" style={{ fontSize: '25px', fontFamily: 'Montserrat' }} />
                        </NavIcon>
                        <NavText style={{ fontSize: '25px', fontFamily: 'Montserrat'}}>
                            Tasks
                        </NavText>
                    </NavItem>
                    <NavItem eventKey="calendar" style={{paddingBottom : '50px'}}>
                        <NavIcon>
                            <i className="fa fa-fw fa-device" style={{ fontSize: '25px', fontFamily: 'Montserrat' }} />
                        </NavIcon>
                        <NavText style={{ fontSize: '25px', fontFamily: 'Montserrat'}}>
                            Calendar
                        </NavText>
                    </NavItem>
                    <NavItem eventKey="setting" style={{paddingBottom : '50px'}}>
                        <NavIcon>
                            <i className="fa fa-fw fa-device" style={{ fontSize: '25px', fontFamily: 'Montserrat' }} />
                        </NavIcon>
                        <NavText style={{ fontSize: '25px', fontFamily: 'Montserrat'}}>
                            Setting
                        </NavText>
                    </NavItem>
                </SideNav.Nav>
            </SideNav>
            <main>
                <Route path="/" exact component={props => <Home />} />
                <Route path="/home" exact component={props => <Home />} />
                <Route path="/tasks" component={props => <Tasks />} />
                <Route path="/calendar" exact component={props => <Calendar />} />
            </main>
        </React.Fragment>
    )}
    />
</Router>
    </div>
  );
}

export default App;