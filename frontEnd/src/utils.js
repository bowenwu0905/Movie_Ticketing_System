import {message} from "antd"

const SERVER_ORIGIN = 'http://localhost:8080';

const getMoviesUrl = `${SERVER_ORIGIN}/girlspower/movies`;

export const getAllMovies = () => {
    return fetch(getMoviesUrl, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json'},
        redirect: 'follow',
    }).then((response) => {
        if (response.status !== 200) {
            throw Error('Fail to get movies information');
        }
        let data = response.json();
        if (data === null) {
            message.warning("Movie info is empty");
        }
        console.log(data);
        return data;
    })
}

const getSectionsByMovieIdUrl = `${SERVER_ORIGIN}/girlspower/sectionsByMovie/`;

export const getSectionsByMovieId = (movieId) => {
    return fetch(`${getSectionsByMovieIdUrl}${movieId}`, {
        method: 'GET',
        redirect: 'follow'
    }).then((response) => {
            if (response.status !== 200) {
                throw Error('Fail to get the sections');
            }
            console.log(response.json());
            return response.json();
        })
}


const createTicketUrl = `${SERVER_ORIGIN}/girlspower/tickets`;

export const createTicket = (ticketInfo) => {
    return fetch(createTicketUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(ticketInfo)
    }).then((response) => {
        if (response.status !== 201) {
            throw Error('Fail to buy a ticket!');
        }
    })
}