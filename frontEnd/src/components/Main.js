import React from 'react';
import {Route, Routes} from "react-router-dom";

import Movies from './Movies';
import Sections from './Sections';


class Main extends React.Component{

  render() {
    return (
        <Routes>
            <Route path="/" element={<Movies/>}/>
            <Route path="/sections" element={<Sections/>}/>
        </Routes>
    )
  }
}

export default Main;