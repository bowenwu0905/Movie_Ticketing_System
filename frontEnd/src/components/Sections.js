import React, { Component } from "react";
import "antd/dist/antd.css";
import { Row, Col, Form, Button, Divider, message, Modal } from "antd";
import {getSectionsByMovieId, createTicket} from "../utils";

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
                sectionId: 0,
                theaterId: 1,
                showTime: "10:30pm",
                roomNumber: 1 
            },
            {
                sectionId: 1,
                theaterId: 2,
                showTime: "6:30pm",
                roomNumber: 2 
            },
            {
              sectionId: 1,
              theaterId: 2,
              showTime: "6:30pm",
              roomNumber: 2 
            },
            {
              sectionId: 1,
              theaterId: 2,
              showTime: "6:30pm",
              roomNumber: 2 
            },
            {
              sectionId: 1,
              theaterId: 2,
              showTime: "6:30pm",
              roomNumber: 2 
            }
        ],
        ticketInfo: {
          sectionId: null,
          audienceId: 0,
          price: "$30",
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
      this.setState({
        movieName: curMovieName
      })
      if (curMovieId !== "") {
        getSectionsByMovieId(parseInt(curMovieId))
              .then(res => {
                  this.setState({
                      sections: [...this.state.sections, res]
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
    createTicket(this.state.ticketInfo)
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
            <h3>Theater ID:  {section.theaterId}</h3>
            <h3>Show Time:  {section.showTime}</h3> 
            <h3>Room Number:  {section.roomNumber}</h3> 
            <h3>Price:  {this.state.ticketInfo.price}</h3>
            <h3>Refundable:  {this.state.ticketInfo.refundable ? "Yes" : "No"}</h3>  
              <Form.Item>
                <Button onClick={()=> {
                    this.setState({
                        showDialog: true
                    });
                  }}
                htmlType="submit" type="primary">
                  Buy Ticket
                </Button>
              </Form.Item>
              <Modal title="Ticket Confirmation" visible={this.state.showDialog} onOk={this.handleOk} onCancel={this.handleCancel}>
                <p>You are choosing section {section.sectionId}</p>
                <p>The theater ID is {section.theaterId}</p>
                <p>For movie "{this.state.movieName}"</p>
                <p>at {section.showTime} in room number {section.roomNumber}</p>
                <p>the price is {this.state.ticketInfo.price}, click OK to submit</p>
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