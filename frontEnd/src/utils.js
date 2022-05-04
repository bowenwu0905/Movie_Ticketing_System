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
            let data = response.json();
            console.log(data);
            return data;
        })
}


const createTicketUrl = `${SERVER_ORIGIN}/girlspower/tickets`;

export const createTicket = (ticketInfo) => {
    return fetch(createTicketUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(ticketInfo),
    }).then((response) => {
        if (response.status !== 200) {
            console.log(response);
            throw Error('Fail to buy a ticket!');
        }
    })
}

const getTicketByAudienceIDUrl = `${SERVER_ORIGIN}/girlspower/ticketsByAudience/`;

export const getTicketByAudienceID = (audienceID) => {
    return fetch(`${getTicketByAudienceIDUrl}${audienceID}`, {
        method: 'GET',
        redirect: 'follow'
    }).then((response) => {
        if (response.status !== 200) {
            throw Error('Fail to get the tickets');
        }
        let data = response.json();
        console.log(data);
        return data;
    })
}

const updateOrDeleteTicketByIDUrl = `${SERVER_ORIGIN}/girlspower/tickets/`;

export const deleteTicketByID = (ticketID) => {
    return fetch(`${updateOrDeleteTicketByIDUrl}${ticketID}`, {
        method: 'DELETE',
    }).then((response) => {
        if (response.status !== 200 || response.status !== 204) {
            throw Error('Fail to delete the tickets');
        }
    })
}

const getSectionsBySectionIdUrl = `${SERVER_ORIGIN}/girlspower/sections/`;

export const getSectionsBySectionId = (sectionID) => {
    return fetch(`${getSectionsBySectionIdUrl}${sectionID}`, {
        method: 'GET',
        redirect: 'follow'
    }).then((response) => {
        if (response.status !== 200) {
            throw Error('Fail to get the sections');
        }
        let data = response.json();
        console.log(data);
        return data;
    })
}
