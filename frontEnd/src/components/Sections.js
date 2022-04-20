import React, { Component } from "react";
import "antd/dist/antd.css";
import { Row, Col, Form, Button, Divider, message, Modal } from "antd";
import {getSectionsByMovieId, createTicket} from "../utils";
import { createNoSubstitutionTemplateLiteral } from "typescript";

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

class Sections extends Component {
    state = {
        movieName: null,
        sections: [
            {
                movie_id: 0,
                room_number: 0,
                section_id: 0,
                showtime: null,
                theater_id: 0, 
            },
        ],
        ticketInfo: {
          sectionID: null,
          audienceID: 6,
          price: 30,
          refundable: false
        },
        showDialog: false
    };

    // get sections by movieId
    componentDidMount() {
      const url = window.location.href;
      console.log(url);
      const params = url.split("&");
      const curMovieId = params[0].substr(39, params[0].length);
      const curMovieName = params[1].substr(10, params[1].length);
      console.log(curMovieId);
      this.setState({
        movieName: curMovieName
      })
      if (curMovieId !== "") {
        getSectionsByMovieId(parseInt(curMovieId))
              .then(res => {
                  this.setState({
                      sections: res
                  });
                  console.log(res);
              })
              .catch(err => {
                  console.log('did not get sections info');
                  message.error(err.message);
              });
      }
  }

  handleCancel = () => {
    this.setState({
      showDialog: false
    })
  };

  handleOk = () => {
    this.setState({
      showDialog: false
    });
    console.log(JSON.stringify(this.state.ticketInfo));
    createTicket(JSON.stringify(this.state.ticketInfo))
              .then(res => {
                  console.log(res);
                  message.success("Ticket purchasing success!");
              })
              .catch(err => {
                  console.log('failed to create ticket');
                  message.error(err.message);
              });
  };

  render() {
    return (
      <div>
        <Row>
          <Col offset={6} span={12}>
            <br />
            <br />
            <Divider>
              <h1>Choose a Section</h1>
            </Divider>
            <br></br>

            <Form
              {...formItemLayout}
              name="section"
              scrollToFirstError
            >{this.state.sections.map((section)=>(
            <div>  
            <h3>Movie Name:  {this.state.movieName}</h3>    
            <h3>Theater ID:  {section.theater_id}</h3>
            <h3>Show Time:  {section.showtime}</h3> 
            <h3>Room Number:  {section.room_number}</h3> 
            <h3>Price:  ${this.state.ticketInfo.price}</h3>
            <h3>Refundable:  {this.state.ticketInfo.refundable ? "Yes" : "No"}</h3>  
              <Form.Item>
                <Button onClick={()=> {
                    this.setState({
                        showDialog: true,
                        ticketInfo: {
                          sectionID: 5,
                          audienceID: 6,
                          price: 30,
                          refundable: false
                        }
                    });
                  }}
                htmlType="submit" type="primary">
                  Buy Ticket
                </Button>
              </Form.Item>
              <Modal title="Ticket Confirmation" visible={this.state.showDialog} onOk={this.handleOk} onCancel={this.handleCancel}>
                <p>You are choosing section {section.section_id}</p>
                <p>The theater ID is {section.theater_id}</p>
                <p>For movie "{this.state.movieName}"</p>
                <p>at {section.showTime} in room number {section.room_number}</p>
                <p>the price is ${this.state.ticketInfo.price}, click OK to submit</p>
              </Modal>
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

export default Sections;