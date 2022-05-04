import React, { Component } from "react";
import "antd/dist/antd.css";
import { Row, Col, Form, Button, Divider, message, Modal } from "antd";
import {getSectionsBySectionId} from "../utils";

const formItemLayout = {
  labelCol: {
    xs: { span: 24 },
    sm: { span: 8 },
  },
  wrapperCol: {
    xs: { span: 24 },
    sm: { span: 16 },
  },
};

class SectionByID extends Component {
    state = {
        sections:
            [{
                movie_id: 0,
                room_number: 0,
                section_id: 0,
                showtime: null,
            }],
    };

    // get sections by movieId
    componentDidMount() {
      const url = window.location.href;
      console.log(url);
      const curSectionId = url.substr(42, url.length);
      if (curSectionId !== "") {
        getSectionsBySectionId(parseInt(curSectionId))
              .then(res => {
                  this.setState({
                      section: res
                  });
                  console.log(res);
              })
              .catch(err => {
                  console.log('did not get section info');
                  message.error(err.message);
              });
      }
  }

  render() {
    return (
      <div>
        <Row>
          <Col offset={6} span={12}>
            <br />
            <br />
            <Divider>
              <h1>Section Info</h1>
            </Divider>
            <br></br>

            <Form
              {...formItemLayout}
              name="section"
              scrollToFirstError
            >{this.state.sections.map((section)=>(
            <div>  
            <h3>Movie ID:  {section.movie_id}</h3>    
            <h3>Theater ID:  {section.theater_id}</h3>
            <h3>Show Time:  {section.showtime}</h3> 
            <h3>Room Number:  {section.room_number}</h3>  
              <br></br>
            </div>
            ))}
            </Form>
          </Col>
        </Row>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

      </div>

    );
  }
}

export default SectionByID;