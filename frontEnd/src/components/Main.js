import React from 'react';
import {Route, Routes} from "react-router-dom";

import Movies from './Movies';
import Sections from './Sections';
import Tickets from './Tickets';
import SectionByID from './SectionByID';


class Main extends React.Component{

  render() {
    return (
        <Routes>
            <Route path="/" element={<Movies/>}/>
            <Route path="/sections" element={<Sections/>}/>
            <Route path="/tickets" element={<Tickets/>}/>
            <Route path="/sectionById" element={<SectionByID/>}/>
        </Routes>
    )
  }
}

export default Main;