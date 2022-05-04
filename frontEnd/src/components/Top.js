import React, {Component} from 'react';
import title from "../assets/title.png";
import {Row, Col, Menu, Button} from 'antd';
import {Link} from "react-router-dom";
import '../styles/Top.css';


class Top extends Component {

    render() {
        return (
            <Row className="App-top">
                <Col className="App-top-logo">
                    <nav>
                        <Link to="/">
                            <img src={title} alt="title-logo" className="App-top-title-logo"/>
                        </Link>
                    </nav>
                </Col>
                <Col>
                    <nav>
                        <Link to="/sections/tickets?audienceID=4">
                            <Button>Go To My Tickets</Button>
                        </Link>
                    </nav>
                </Col>


            </Row>
        )
    }
}

export default Top;