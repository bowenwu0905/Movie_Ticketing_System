import React, { Component } from "react";
import "antd/dist/antd.css";
import { Row, Col, Form, Button, Divider, message, Modal } from "antd";
import {getTicketByAudienceID, deleteTicketByID} from "../utils";
import { Navigate } from "react-router-dom"

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

class Tickets extends Component {
    state = {
        tickets: [ {
          ticketID: null,
          sectionID: null,
          audienceID: null,
          price: 0,
          refundable: false
        } ],
        redirect: false,
        curSectionID: null,
    };

    // get tickets by audienceID
    componentDidMount() {
      const url = window.location.href;
      console.log(url);
      const curAudienceId = url.substr(50, url.length);
      console.log(curAudienceId);
      if (curAudienceId !== "") {
        getTicketByAudienceID(parseInt(curAudienceId))
              .then(res => {
                  this.setState({
                      tickets: res
                  });
                  console.log(res);
              })
              .catch(err => {
                  console.log('did not get tickets info');
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
              <h1>Tickets Info</h1>
            </Divider>
            <br></br>

            <Form
              {...formItemLayout}
              name="ticket"
              scrollToFirstError
            >{this.state.tickets.map((ticket)=>(
            <div>  
            <h3>Price:  ${ticket.price}</h3>
            <h3>Refundable:  {ticket.refundable ? "Yes" : "No"}</h3>  
              <Form.Item>
                <Button onClick={()=> {
                    deleteTicketByID(ticket.ticketID)
                    .then(res => {
                        console.log(res);
                        message.success("Ticket Cancellation success!");
                    })
                    .catch(err => {
                        console.log('failed to cancel ticket');
                        message.error(err.message);
                    });
                }}
                htmlType="submit" type="primary">
                  Delete Ticket
                </Button>
                <br></br>
                <br></br>
                <Button onClick={()=> {
                    this.setState({
                      curSectionID: ticket.sectionID,
                      redirect: true
                    })
                }}
                htmlType="submit" type="primary">
                  Go to Section
                </Button>
                {this.state.redirect && <Navigate to={`sectionById?sectionID=${this.state.curSectionID}`} replace={true} />}
              </Form.Item>
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

export default Tickets;