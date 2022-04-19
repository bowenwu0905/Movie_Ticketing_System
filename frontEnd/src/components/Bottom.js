
import React, {Component} from 'react';
import {Row, Col} from 'antd';


class Bottom extends Component {
    render() {
        return (
            <Row>
                <Col span={4} className="App-bottom">
                    <h3>MovieTicketing ©2022</h3>
                </Col>

                <Col span={4} />
                <Col span={4} />
                <Col span={4} />
                <Col span={2} />
                <Col span={2} className="App-bottom">
                    <h4>CONTACT US</h4>
                </Col>

                <Col span={2} className="App-bottom">
                    <h4>TERMS OF USE</h4>
                </Col>

                <Col span={2} className="App-bottom">
                    <h4>PRIVACY</h4>
                </Col>


            </Row>
        );
    };
}

export default Bottom;