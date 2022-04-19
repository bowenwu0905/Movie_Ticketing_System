import React from "react";
import {BrowserRouter as Router} from "react-router-dom";
import {Layout} from 'antd';

import Top from './components/Top';
import Bottom from './components/Bottom';
import Main from './components/Main';

const {Header, Footer, Content} = Layout;

class App extends React.Component {
    
    render() {
        return (
            <Router>
                <Layout>
                    <Header className="App-header">
                        <Top/>
                    </Header>

                    <Content className="App-content">
                        <Main/>
                    </Content>

                    <Footer className="App-footer">
                        <Bottom />
                    </Footer>
                </Layout>
            </Router>
        )
    };
}

export default App;