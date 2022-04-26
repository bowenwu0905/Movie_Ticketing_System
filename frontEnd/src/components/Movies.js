import React, { Component } from "react";
import "antd/dist/antd.css";
import { Row, Col, Form, Button, Divider, message } from "antd";
import { Navigate } from "react-router-dom"
import {getAllMovies} from "../utils";

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

class Movies extends Component {
    state = {
        movies: [
            {
                movie_id: null,
                movie_name: null,
                movie_type: null,

            }
        ],
        redirect:false,
        movieId: null,
        movieName: null
    };

    // get all movies
    componentDidMount() {
        getAllMovies()
            .then(res => {
                this.setState({
                    movies: res
                });
                console.log(res);
            })
            .catch(err => {
                console.log('did not get movies info');
                message.error(err.message);
            });
    }

  render() {
    return (
      <div>
        <Row>
          <Col offset={6} span={12}>
            <br />
            <br />
            <Divider>
              <h1>Choose a Movie</h1>
            </Divider>
            <br></br>

            <Form
              {...formItemLayout}
              name="movie"
              scrollToFirstError
            >{this.state.movies.map((movie)=>(
            <div>      
            <h3>Movie Type:  {movie.movie_type}</h3>
            <h3>Movie Name:  {movie.movie_name}</h3>
              <Form.Item>
                <Button onClick={()=> {
                    this.setState({
                        redirect: true,
                        movieId: movie.movie_id,
                        movieName: movie.movie_name
                    });
                    console.log(this.state.redirect);
                }} htmlType="submit" type="primary">
                  Choose
                </Button>
              </Form.Item>
              {this.state.redirect && <Navigate to={`sections?movieId=${this.state.movieId}&movieName=${this.state.movieName}`} replace={true} />}
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

export default Movies;